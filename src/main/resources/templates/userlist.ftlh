<#ftl encoding='Windows-1251'>
<#import "parts/common.ftlh" as c>

<@c.page>
    Список пользователей
    <table>
        <thead>
        <tr>
            <th>Имя пользователя</th>
            <th>Роли</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/admin/${user.getUsr_id()}">Редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>