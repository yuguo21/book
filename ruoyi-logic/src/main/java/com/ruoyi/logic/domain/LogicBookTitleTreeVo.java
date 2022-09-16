package com.ruoyi.logic.domain;

public class LogicBookTitleTreeVo {

    private Long id;

    private Long pId;

    private String name;

    private String title;

    private boolean checked;

    private boolean open;

    private boolean nocheck;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return false;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return false;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isNocheck() {
        return false;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }
}
