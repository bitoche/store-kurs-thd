<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>acceptance</title>
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
<h1>revaluation_act</h1>
<a href="/">На главную</a>
<a href="/acceptance">Перезагрузить</a>
<div class="tableContainer">
    <table>
        <thead>
        <th>id</th>
        <th><a href="/store">id_store</a></th>
        <th><a href="/stock">id_stock</a></th>
        <th>wholesale_price</th>
        <th>date</th>
        </thead>
        <#if listAcceptance ?has_content>
            <tbody>
            <#list listAcceptance?sort_by('id') as ra>
                <tr>
                    <td>${ra.id?string('0')}</td>
                    <td>${ra.id_store?string('0')}</td>
                    <td>${ra.id_stock?string('0')}</td>
                    <td>${ra.wholesale_price?string('0')}</td>
                    <td>${ra.getStringDate()}</td>
                </tr>
            </#list>
            </tbody>
        </#if>
    </table>
</div>
</body>
