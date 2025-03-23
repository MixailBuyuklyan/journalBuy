<#import "parts/common.ftlh" as c>
    <html lang="en">
<@c.page>
    <div>
        <form method="post">
            <input type="text" name="fio" placeholder="Введите ФИО" />

            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список студентов</div>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <button type="submit">Haйти</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>Имя студента </th>
            <th>Группа</th>
        </tr>
        </thead>
        <tbody>
        <#list students as student>
            <tr>
                <td>${student.getName()}</td>

            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>