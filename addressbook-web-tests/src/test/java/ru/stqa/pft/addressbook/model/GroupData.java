package ru.stqa.pft.addressbook.model;

public class GroupData {

    private int idOfGroup= Integer.MAX_VALUE;
    private String nameOfGroup;
    private String headerOfGroup;
    private String footerOfGroup;


    public GroupData withId(int idOfGroup) {
        this.idOfGroup = idOfGroup;
        return this;
    }

    public GroupData withName(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
        return this;
    }

    public GroupData withHeader(String headerOfGroup) {
        this.headerOfGroup = headerOfGroup;
        return this;
    }

    public GroupData withFooter(String footerOfGroup) {
        this.footerOfGroup = footerOfGroup;
        return this;
    }

    public int getId() {
        return idOfGroup;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public String getHeaderOfGroup() {
        return headerOfGroup;
    }

    public String getFooterOfGroup() {
        return footerOfGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return nameOfGroup != null ? nameOfGroup.equals(groupData.nameOfGroup) : groupData.nameOfGroup == null;
    }

    @Override
    public int hashCode() {
        return nameOfGroup != null ? nameOfGroup.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "idOfGroup='" + idOfGroup + '\'' +
                ", nameOfGroup='" + nameOfGroup + '\'' +
                '}';
    }

}
