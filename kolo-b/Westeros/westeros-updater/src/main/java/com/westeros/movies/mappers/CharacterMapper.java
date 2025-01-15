package com.westeros.movies.mappers;

import com.westeros.data.model.ActorRole;
import com.westeros.moviesclient.contract.CreditsDto;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper implements IMapEntities<CreditsDto.ActorSummaryDto, ActorRole>{


    @Override
    public ActorRole map(CreditsDto.ActorSummaryDto actorSummaryDto) {
        return map(actorSummaryDto, new ActorRole());
    }

    @Override
    public ActorRole map(CreditsDto.ActorSummaryDto actorSummaryDto, ActorRole characterRole) {
        characterRole.setName(actorSummaryDto.character());
        return characterRole;
    }
}
