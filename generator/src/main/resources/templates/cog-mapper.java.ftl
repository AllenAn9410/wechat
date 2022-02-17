package ${package.Mapper};

import ${package.Entity}.${entity};
import ${package.Entity}.join.${entity}JoinServices;
import ${superMapperClassPackage};
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
  /**
   * 查询扩展
   *
   * @param wrapper 动态参数
   * @return List<${table.entityName}JoinServices>
   * */
  List<${table.entityName}JoinServices> select${table.entityName}JoinServices(@Param("ew") Wrapper<${entity}> wrapper);
}
</#if>
