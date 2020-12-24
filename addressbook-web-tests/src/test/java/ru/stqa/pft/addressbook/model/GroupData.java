package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
@XStreamAlias("group")
public class GroupData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;


    public GroupData withId(int idOfGroup) {
        this.id = idOfGroup;
        return this;
    }

    public GroupData withName(String nameOfGroup) {
        this.name = nameOfGroup;
        return this;
    }

    public GroupData withHeader(String headerOfGroup) {
        this.header = headerOfGroup;
        return this;
    }

    public GroupData withFooter(String footerOfGroup) {
        this.footer = footerOfGroup;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
