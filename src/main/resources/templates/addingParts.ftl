<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post">
    <div>
        <input type="text" name="name" placeholder="Part name"/>
    </div>
    <div>

        <select name="isNecessary">
            <option value="Да">Да</option>
            <option value="Нет">Нет</option>
        </select>
    </div>
    <div>
        <input type="number" name="amount" placeholder="amount">
    </div>
    <div>
        <button type="submit">Save</button>
    </div>
    </form>
</@c.page>