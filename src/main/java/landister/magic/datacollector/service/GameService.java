/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package landister.magic.datacollector.service;

import landister.magic.datacollector.domain.Game;
import landister.magic.datacollector.repository.GameCardRepository;
import landister.magic.datacollector.repository.GameRepository;
import landister.magic.datacollector.util.LocalCollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameCardRepository gameCardRepository;

    public Game getGameInfo(Integer gameId){
        return populateGame(gameRepository.findOne(gameId));
    }

    public List<Game> getGameInfo(String name){
        List<Game> result;
        if(name == null || name.isEmpty()){
            result = LocalCollectionUtil.makeList(gameRepository.findAll());
        }
        else{
            result = gameRepository.findByUserName(name);
        }
        result.stream().forEach(game -> populateGame(game));
        return result;
    }

    private Game populateGame(Game game){
        game.setCards(LocalCollectionUtil.makeList(gameCardRepository.findByGame(game)));
        return game;
    }

    public Game saveGame(Game game){
        if(game.getCards() != null){
            game.getCards().forEach(card -> card.setGame(game));
        }
        Game savedGame = gameRepository.save(game);
        return savedGame;
    }
}
