package com.example.services.interfaces;

public interface ICommand<T, R> {
    R execute(T input);
}