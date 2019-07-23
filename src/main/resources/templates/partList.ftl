<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <#list parts as part>
            <div>
                <span>${part.name}</span>
                <span>${part.necessariness}</span>
                <span>${part.amount}</span>
            </div>
        </#list>
    </div>
</@c.page>