<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Возвраты</title>
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
<h1>Возвраты</h1>
<a href="/">На главную</a>
<a href="/returns">Перезагрузить</a>
<button id="showFormButton" class="addContainer">+</button>
<div class="addContainer" id="addContainer" title="Добавление" style="display: none">
    <form action="/returns/add" method="post">
        <input name="id_product" placeholder="ID Продукта" required/>
        <input name="cause" placeholder="Причина" required/>
        <button type="submit">Добавить</button>
    </form>

</div>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th><a href="/product">id_product</a></th>
        <th>cause</th>
        <th>date</th>
        <th>Управление</th>
        </thead>
        <#if listReturns ?has_content>
            <tbody>
            <#list listReturns?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.id_product?string('0')}</td>
                    <td>${ra.cause}</td>
                    <td>${ra.getStringDate()}</td>
                    <td>
                        <a href="/returns/delete/${ra.id}"
                           style="color: black; background: #efefef; padding: 1px; text-align: center; text-decoration: none; outline: none; border: solid #1a1a1a 1px; border-radius: 10%">Удалить</a>
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

    // Добавляем обработчик события для клика на кнопку
    showFormButton.addEventListener('click', function () {
        // При клике на кнопку изменяем стиль отображения div
        formContainer.style.display = 'block';
        showFormButton.style.display = 'none';
    });
</script>
