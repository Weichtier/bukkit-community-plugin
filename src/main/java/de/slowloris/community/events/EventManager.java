/*
 *     Copyright (c) 2018 Slowloris.de                                                         
 *     Development: Weichtier                                                                                
 *                                                                                                                                 
 *     Ändern für den privaten nutzen erlaubt. Reuploaded verboten!             
 */

package de.slowloris.community.events;

import de.slowloris.community.utils.ScoreboardBuilder;

public class EventManager {
    
    private String actualEvent = "None";
    private EventType eventType = EventType.NONE;
    private PvPEvent pvPEvent = new PvPEvent();
    private GriefEvent griefEvent = new GriefEvent();
    
    public EventManager(){
    }

    public String getActualEvent() {
        return actualEvent;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void launchEvent(EventType type){
        if (this.getEventType().equals(type)){
            actualEvent = "None";

            if(this.eventType == EventType.PVP){
                pvPEvent.setIngame(false);
            }else if(this.eventType == EventType.GRIEF){
                griefEvent.setIngame(false);
            }

            this.eventType = EventType.NONE;
            ScoreboardBuilder.updateForAll();
        }else {
            if(type.equals(EventType.PVP)){
                actualEvent = "PvP";

                ScoreboardBuilder.updateForAll();

                this.eventType = type;
                pvPEvent.setIngame(true);
            }else if(type.equals(EventType.GRIEF)){
                actualEvent = "Grief";

                ScoreboardBuilder.updateForAll();

                this.eventType = type;
                griefEvent.setIngame(true);
            }
        }
    }    
    
}
