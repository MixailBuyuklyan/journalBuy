<#ftl encoding='Windows-1251'>
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">Добавить нового пользователя</div>
    <@l.login "/registration" true/>
</@c.page>