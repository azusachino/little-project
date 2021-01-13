package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;

/**
* @author ${author}
*/
<#if kotlin>
    interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
    @Repository
    public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    }
</#if>
