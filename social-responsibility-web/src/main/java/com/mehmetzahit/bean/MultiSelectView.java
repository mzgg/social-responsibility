package com.mehmetzahit.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
public class MultiSelectView {

    private List<SelectItem> categories;
    private String selection;

    @PostConstruct
    public void init() {
        categories = new ArrayList<SelectItem>();

        SelectItemGroup[] group=new SelectItemGroup[3];
        SelectItemGroup[] group22=new SelectItemGroup[4];


        for(int i=1; i<3;i++){
            String a=Integer.toString(i);
            group[i]=new SelectItemGroup(a);

        }

        for(int i=1; i<4;i++) {
            String a=Integer.toString(i);
            group22[i]=new SelectItemGroup(a);
        }


            SelectItemGroup group1 = new SelectItemGroup("Kedi");


        SelectItemGroup group11 = new SelectItemGroup("Ankara Kedisi");
        SelectItemGroup group12 = new SelectItemGroup("Van Kedisi");


        SelectItem option111 = new SelectItem("Eğitimli");
        SelectItem option112 = new SelectItem("Eğtimsiz");



        group11.setSelectItems(new SelectItem[]{option111, option112});




        group1.setSelectItems(new SelectItem[]{group11, group12});


        categories.add(group1);

    }

    public List<SelectItem> getCategories() {
        return categories;
    }

    public String getSelection() {
        return selection;
    }
    public void setSelection(String selection) {
        this.selection = selection;
    }
}