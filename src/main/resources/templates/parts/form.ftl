<#macro form>
    <div><a class="btn btn-primary m-1" href="/partsList">Список запчастей</a></div>
    <form method="post">
        <div>
            Название детали:
            <input class="form-control-sm m-1" type="text" name="name" placeholder="Название детали">
        </div>

        <div>
            Необходимость:
            <select name="necessary">
                <option value="Да">Да</option>
                <option value="Нет">Нет</option>
            </select>
        </div>

        <div>
            Количество:
            <input class="form-control-sm m-1" type="number" name="amount" placeholder="Количество">
        </div>
        <button class="btn btn-success m-1" type="submit">Save</button>
    </form>
</#macro>