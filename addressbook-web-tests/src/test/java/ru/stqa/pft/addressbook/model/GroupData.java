package ru.stqa.pft.addressbook.model;

public class GroupData {

    private int idOfGroup;
    private final String nameOfGroup;
    private final String headerOfGroup;
    private final String footerOfGroup;

    public GroupData(String nameOfGroup, String headerOfGroup, String footerOfGroup) {
        this.idOfGroup = 0;
        this.nameOfGroup = nameOfGroup;
        this.headerOfGroup = headerOfGroup;
        this.footerOfGroup = footerOfGroup;
    }

    public GroupData(int idOfGroup, String nameOfGroup, String headerOfGroup, String footerOfGroup) {
        this.idOfGroup = idOfGroup;
        this.nameOfGroup = nameOfGroup;
        this.headerOfGroup = headerOfGroup;
        this.footerOfGroup = footerOfGroup;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (idOfGroup != groupData.idOfGroup) return false;
        return nameOfGroup != null ? nameOfGroup.equals(groupData.nameOfGroup) : groupData.nameOfGroup == null;
    }

    @Override
    public int hashCode() {
        int result = idOfGroup;
        result = 31 * result + (nameOfGroup != null ? nameOfGroup.hashCode() : 0);
        return result;
    }

    public void setIdOfGroup(int idOfGroup) {
        this.idOfGroup = idOfGroup;
    }

    public int getIdOfGroup() {
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
    public String toString() {
        return "GroupData{" +
                "idOfGroup='" + idOfGroup + '\'' +
                ", nameOfGroup='" + nameOfGroup + '\'' +
                '}';
    }
}
