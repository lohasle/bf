package org.lohas.bf.dao.entities;

public class LoggingEventException {
    private String traceLine;
    private Long eventId;

    private Short i;

    public String getTraceLine() {
        return traceLine;
    }

    public void setTraceLine(String traceLine) {
        this.traceLine = traceLine == null ? null : traceLine.trim();
    }


    public Short getI() {
        return i;
    }

    public void setI(Short i) {
        this.i = i;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}