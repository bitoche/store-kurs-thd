<!DOCTYPE html>
<html lang="ru" id="page">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Продукты</title>
    <link rel="stylesheet" href="css/table.css">
    <style>
        .filterContainer {
            padding: 10px;
            border: solid #eee 1px;
            margin: 3px 3px 10px;
        }
    </style>
</head>
<body>
<h1>Продукты</h1>
<a href="/">На главную</a>
<a href="/product">Перезагрузить</a>
<br/>
<button id="showFormButton" class="addContainer">+</button>
<div class="addContainer" id="addContainer" title="Добавление" style="display: none">
    <form action="/product/add" method="post">
        <input name="name" placeholder="Название" required/>
        <input name="unit" placeholder="Ед.изм" required/>
        <input name="price" placeholder="Стоимость" required/>
        <input name="description" placeholder="Описание"/>
        <button type="submit">Добавить</button>
    </form>

</div>

<details>
    <summary>Поиск по фильтрам</summary>
    <div class="filterContainer">
        <label>Поиск по названию/фирме</label>
        <form action="/product/filterByName" method="get">
            <input name="value" placeholder="Название" required/>
            <button type="submit">Найти</button>
        </form>
    </div>
    <div class="filterContainer">
        <label>Поиск по дате переоценки</label>
        <form action="/product/filterByDateOfRevaluation" method="post" style="align-content: baseline">
            С <input name="dateFrom" placeholder="dd/mm/yyyy" required/>
            до <input name="dateFor" placeholder="dd/mm/yyyy" required/>
            <button type="submit">Найти</button>
        </form>
    </div>
    <div class="filterContainer">
        <label>Поиск по возвратам</label>
        <form action="/product/filterByReturns" method="post" style="align-content: baseline">
            С <input name="dateFrom" placeholder="dd/mm/yyyy" required/>
            до <input name="dateFor" placeholder="dd/mm/yyyy" required/>
            <button type="submit">Найти</button>
        </form>
    </div>
</details>
<br/>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th>name</th>
        <th>unit</th>
        <th>price</th>
        <th>description</th>
        <th><a href="/revaluation_act">previous_price</a></th>
        <th>Управление</th>
        </thead>
        <#if listProducts ?has_content>
            <tbody>
            <#list listProducts?sort_by('id') as pr>
                <tr>
                    <td>${pr.id?string('0')}</td>
                    <td>${pr.name}</td>
                    <td>${pr.unit}</td>
                    <td>${pr.price?string('0')}</td>
                    <td>
                        <#if pr.description?has_content>
                            ${pr.description}
                        </#if>
                    </td>
                    <td>
                        <#if pr.previous_price?has_content>
                            ${pr.previous_price?string('0')}
                        </#if>
                    </td>
                    <td>
                        <a href="product/delete/${pr.id}"
                           style="color: black; background: #efefef; padding: 1px; text-align: center; text-decoration: none; outline: none; border: solid #1a1a1a 1px; border-radius: 10%">Удалить</a>
                        <button class="editButton" data-product-id="${pr.id}">Изменить</button>
                        <div class="editContainer" id="editContainer-${pr.id}"
                             style="display: none; margin:10px; padding:10px;">
                            <form action="/product/edit/" method="post">
                                <input hidden name="id" value="${pr.id?string('0')}"/>
                                <label>name</label>
                                <input value="${pr.name}" required name="name"/><br>
                                <label>unit</label>
                                <input value="${pr.unit}" required name="unit"/><br>
                                <label>price</label>
                                <input value="${pr.price?string('0')}" required name="price"/><br>
                                <label>description</label>
                                <input value="<#if pr.description?has_content>${pr.description}</#if>"
                                       name="description"/><br>
                                <button type="submit">Сохранить</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>

</body>
<script>
    const showFormButton = document.getElementById('showFormButton');
    const formContainer = document.getElementById('addContainer');
    const editButtons = document.querySelectorAll('.editButton');
    const editContainer = document.getElementById('editContainer');

    // Добавляем обработчик события для клика на кнопку
    showFormButton.addEventListener('click', function () {
        // При клике на кнопку изменяем стиль отображения div
        formContainer.style.display = 'block';
        showFormButton.style.display = 'none';
    });

    // Добавляем обработчик события для каждой кнопки "Изменить"
    editButtons.forEach((button) => {
        button.addEventListener('click', function () {
            const productId = this.dataset.productId;
            const editContainer = document.getElementById(`editContainer-` + productId);

            // При клике на кнопку изменяем стиль отображения div
            editContainer.style.display = 'block';
            editContainer.style.position = 'absolute';
            editContainer.style.right = '0';
            editContainer.style.top = '0';
        });
    });
</script>
</html>
