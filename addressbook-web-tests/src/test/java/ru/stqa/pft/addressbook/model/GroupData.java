package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String nameOfGroup;
    private final String headerOfGroup;
    private final String footerOfGroup;


    public GroupData(String nameOfGroup, String headerOfGroup, String footerOfGroup) {
<<<<<<< HEAD
<<<<<<< HEAD
        this.idOfGroup = Integer.MAX_VALUE;
        this.nameOfGroup = nameOfGroup;
        this.headerOfGroup = headerOfGroup;
        this.footerOfGroup = footerOfGroup;
    }

    public GroupData(int idOfGroup, String nameOfGroup, String headerOfGroup, String footerOfGroup) {
        this.idOfGroup = idOfGroup;
=======
>>>>>>> parent of b9dea0b... 4.9 работает
=======
>>>>>>> parent of b9dea0b... 4.9 работает
        this.nameOfGroup = nameOfGroup;
        this.headerOfGroup = headerOfGroup;
        this.footerOfGroup = footerOfGroup;
    }

<<<<<<< HEAD
<<<<<<< HEAD

    public void setIdOfGroup(int idOfGroup) {
        this.idOfGroup = idOfGroup;
    }

    public int getIdOfGroup() {
        return idOfGroup;
    }

=======
>>>>>>> parent of b9dea0b... 4.9 работает
=======
>>>>>>> parent of b9dea0b... 4.9 работает
    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public String getHeaderOfGroup() {
        return headerOfGroup;
    }

    public String getFooterOfGroup() {
        return footerOfGroup;
    }
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
>>>>>>> parent of b9dea0b... 4.9 работает
=======
>>>>>>> parent of b9dea0b... 4.9 работает
}
