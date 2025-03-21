<#ftl encoding='Windows-1251'>
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h1>Регистрация завершена!</h1>
    <p>Ваш аккаунт был успешно создан.</p>
    <@l.login "/login" false/>
</@c.page>