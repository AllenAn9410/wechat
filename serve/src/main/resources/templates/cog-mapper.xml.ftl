<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>
    </#if>

    <#if baseResultMap>
        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
            <#list table.fields as field>
                <#if field.keyFlag><#--生成主键排在第一位-->
                    <id column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>
            <#list table.commonFields as field><#--生成公共字段 -->
                <result column="${field.name}" property="${field.propertyName}" />
            </#list>
            <#list table.fields as field>
                <#if !field.keyFlag><#--生成普通字段 -->
                    <result column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>
        </resultMap>

        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultJoinMap" type="${package.Entity}.join.${entity}JoinServices">
        <#list table.fields as field>
            <#if field.keyFlag><#--生成主键排在第一位-->
                <id column="${field.name}" property="${field.propertyName}" />
            </#if>
        </#list>

        <#list table.commonFields as field><#--生成公共字段 -->
            <result column="${field.name}" property="${field.propertyName}" />
        </#list>

        <#list table.fields as field>
            <#if !field.keyFlag><#--生成普通字段 -->
                <result column="${field.name}" property="${field.propertyName}" />
            </#if>
        </#list>

        <#list table.fields as field>
            <#if field.refTable?? ><#--生成普通字段 -->
                <!-- 这里是外键 -->
                <association property="${field.joinEntityName}" resultMap="${package.Mapper}.${field.refTable.mapperName}.BaseResultMap"></association>
            </#if>
        </#list>
        </resultMap>
    </#if>

    <#if baseColumnList>
        <!-- 通用查询结果列 -->
        <sql id="BaseColumnList">
            <#list table.fields as field>
                `${table.name}`.${field.name}<#if field_has_next>,</#if>
            </#list>
        </sql>

        <!-- 通用查询结果列 -->
        <sql id="BaseColumnListJoin">
            <#list table.fields as field>
                `${table.name}`.${field.name}<#if field_has_next>,</#if>
            </#list>
            <#list table.fields as field>
                <#if field.refTable?? >
                ,<include refid="${package.Mapper}.${field.refTable.mapperName}.BaseColumnList" />
                </#if>
            </#list>
        </sql>
    </#if>


    <select id="select${table.entityName}JoinServices" resultMap="BaseResultJoinMap">
        select
            <include refid="BaseColumnList" />
        <#list table.fields as field>
            <#if field.refTable?? >
            ,<include refid="${package.Mapper}.${field.refTable.mapperName}.BaseColumnList" />
            </#if>
        </#list>
        from  ${table.name} `${table.name}`
        <#list table.fields as field>
        <#if field.refTable?? >
        left join ${field.refTable.name} `${field.refTable.name}` on `${field.refTable.name}`.${field.refField} = `${table.name}`.${field.name}
        </#if>
        </#list>
        <where>
            ${r'${ew.sqlSegment}'}
        </where>
    </select>


</mapper>
