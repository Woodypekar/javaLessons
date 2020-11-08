package ru.stqa.pft.addressbook;

public class GroupData {
    private final String nameOfGroup;
    private final String headerOfGroup;
    private final String footerOfGroup;

    public GroupData(String nameOfGroup, String headerOfGroup, String footerOfGroup) {
        this.nameOfGroup = nameOfGroup;
        this.headerOfGroup = headerOfGroup;
        this.footerOfGroup = footerOfGroup;
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
}
