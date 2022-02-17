package cn.ax.code.generator.utils;


import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * @author 李新宇
 * @className CustomTableField
 * @date 2021/10/5
 **/
public class CustomTableField extends TableField {
    private TableInfo refTable;
    private String refField;

    private String joinEntityName;

    public CustomTableField(TableField field){
        super.setConvert(field.isConvert());
        super.setKeyFlag(field.isKeyFlag());
        super.setKeyIdentityFlag(field.isKeyIdentityFlag());
        super.setName(field.getName());
        super.setType(field.getType());
        super.setPropertyName(field.getPropertyName());
        super.setColumnType(field.getColumnType());
        super.setComment(field.getComment());
        super.setFill(field.getFill());
        super.setKeyWords(field.isKeyWords());
        super.setColumnName(field.getColumnName());
        super.setCustomMap(field.getCustomMap());
    }

    public String getJoinEntityName() {
        return joinEntityName;
    }

    public void setJoinEntityName(String joinEntityName) {
        this.joinEntityName = joinEntityName;
    }

    public TableInfo getRefTable() {
        return refTable;
    }

    public String getRefField(){return refField;}

    public void setRefTable(TableInfo refTable) {
        this.refTable = refTable;
        this.joinEntityName = refTable.getEntityName().substring(0,1).toLowerCase() + refTable.getEntityName().substring(1) + "Join";
    }

    public void setRefField(String field){
        this.refField = field;
    }

}
