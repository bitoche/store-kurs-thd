<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>stock</title>
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
<h1>stock</h1>
<a href="/">На главную</a>
<a href="/stock">Перезагрузить</a>
<details>
    <summary>Поиск по фильтрам</summary>
    <div class="filterContainer">
        <label>Поиск по товару</label>
        <form action="/stock/filterByProduct" method="get">
            <input name="value" placeholder="Название/фирма" required/>
            <button type="submit">Найти</button>
        </form>
    </div>
</details>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th>address</th>
        <th>name</th>
        <th><a href="/product">id_product</a></th>
        <th>count</th>
        <th>Управление</th>
        </thead>
        <#if listStock ?has_content>
            <tbody>
            <#list listStock?sort_by('id') as st>
                <tr>
                    <td>${st.id?string('0')}</td>
                    <td>${st.address}</td>
                    <td>${st.name}</td>
                    <td>${st.id_product?string('0')}</td>
                    <td>${st.count?string('0')}</td>
                    <td>
                        <a href="/stock/delete/${st.id}"
                           style="color: black; background: #efefef; padding: 1px; text-align: center; text-decoration: none; outline: none; border: solid #1a1a1a 1px; border-radius: 10%">Удалить</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
