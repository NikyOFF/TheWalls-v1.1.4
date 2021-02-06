package com.nikyoff.thewalls.core;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RoundAwakeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Map currentMap;

    public RoundAwakeEvent(Map currentMap) {
        this.currentMap = currentMap;
    }

    public Map GetCurrentMap() {
        return this.currentMap;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
