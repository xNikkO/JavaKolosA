package com.westeros.movies.mappers;

public interface IMapEntities<TDto, TEntity> {

    TEntity map(TDto dto);
    TEntity map(TDto dto, TEntity entity);
}
