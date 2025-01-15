package com.westeros.webapi.services.mappers;

public interface IMap<TValue, TResult> {

    TResult map(TValue item);
}
