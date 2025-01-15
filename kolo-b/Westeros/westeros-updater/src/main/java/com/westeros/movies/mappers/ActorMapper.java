package com.westeros.movies.mappers;

import com.westeros.data.model.Actor;
import com.westeros.moviesclient.contract.ActorDto;
import org.springframework.stereotype.Component;


@Component
public class ActorMapper implements IMapEntities<ActorDto, Actor>{
    @Override
    public Actor map(ActorDto actorDto) {
        return map(actorDto, new Actor());
    }

    @Override
    public Actor map(ActorDto actorDto, Actor actor) {
        actor.setSourceId((int)actorDto.id());
        actor.setName(actorDto.name());
        actor.setAlsoKnownAs(alsoKnownAs(actorDto));
        actor.setBiography(actorDto.biography());
        actor.setProfilePath(actorDto.profilePath());
        actor.setPopularity(actorDto.popularity());
        actor.setBirthday(actorDto.birthday());
        actor.setDeathday(actorDto.deathday());
        return actor;
    }

    private String alsoKnownAs(ActorDto dto){
        return String.join(";", dto.alsoKnownAs());
    }
}
