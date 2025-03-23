<#ftl encoding='Windows-1251'>
<#import "parts/common.ftlh" as c>

<@c.page>
    Редактор данных о пользователе
    <form action="/admin/${user.getUsr_id()}" method="post">  <!-- 1. Исправлен URL -->
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox"
                           name="roles"
                           value="${role}"
                            ${user.roles?seq_contains(role)?then("checked", "")}>  <!-- 4. Упрощен синтаксис -->
                    ${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="/admin/${user.getUsr_id()}" name="userId">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>