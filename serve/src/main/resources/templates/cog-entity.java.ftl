package ${package.Entity}.join;

import ${package.Entity}.*;
import lombok.Data;

/**
* ${table.comment!}
*
* @author anx
* @since ${date}
*/
<#if entityLombokModel>
@Data
</#if>
public class ${table.entityName}JoinServices extends ${table.entityName} {

<#list table.fields as field>
<#if field.refTable?? >
    private ${field.refTable.entityName} ${field.joinEntityName};
</#if>
</#list>
}
