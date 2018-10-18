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
package landister.magic.datacollector.controller;

import landister.magic.datacollector.domain.Game;
import landister.magic.datacollector.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;

@Path("/game")
@Component
@Api(value = "Data Collection Endpoints")
public class GameController {


    @Autowired
    GameService gameService;

    @GET
    @Produces("application/json")
    public List<Game> findGame(@QueryParam("name") String name) {
        return gameService.getGameInfo(name);
    }


    @GET
    @Produces("application/json")
    @Path("{id}")
    public Game findGame(@PathParam("id") Integer gameId) {
        return gameService.getGameInfo(gameId);
    }

    @POST
    @Produces("application/json")
    public Game greeting(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

}
