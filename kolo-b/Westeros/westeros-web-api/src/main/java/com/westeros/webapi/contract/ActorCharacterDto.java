package com.westeros.webapi.contract;

public class ActorCharacterDto {
    private String characterName;
    private String actorName;
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public String getActorName() {
        return actorName;
    }
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
