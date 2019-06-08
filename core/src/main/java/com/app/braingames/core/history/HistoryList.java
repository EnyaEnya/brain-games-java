package com.app.braingames.core.history;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HistoryList {

    @XmlElementWrapper(name = "records")
    @XmlElement(name = "record")
    private List<HistoryRecord> records = new ArrayList<>();

    public List<HistoryRecord> getRecords() {
        return records;
    }

    public void setRecords(List<HistoryRecord> records) {
        this.records = records;
    }
}
