<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
        <h1>Goldeneye</h1>
        <h2>Email Creator</h2>
        <#if employee?? >
            <p>This is your data:</p>
            <div class="data">
                <p>Name: ${employee.name}</p>
                <p>Surname: ${employee.surname}</p>
                <p>Location: ${employee.location}</p>
                <p>Department: ${employee.department}</p>
            </div>
            <#if employee.email?? >
                <p>and here is your company email:</p>
                <p class="email">${employee.email}</p>
            <#else>
                <p>Location and Department don't match with the valid options:</p>
                <p>Departments in Milan: Design, Business & Advertising</p>
                <p>Departments in Spain: Research and development & Business</p>
                <p>Departments in New York: Business & Advertising</p>
            </#if>
        <#else>
            <p>Please, fill the following form in order to receive a company email address.</p>
            <form action="/" method="post">
                <div class="label">Name:</div>
                <input type="text" name="name">
                <div class="label">Surname:</div>
                <input type="text" name="surname">
                <div class="label">Office Location:</div>
                <div>
                    <select name="location">
                        <option value="Milan">Milan</option>
                        <option value="Spain">Spain</option>
                        <option value="New York">New York</option>
                    </select>
                </div>
                <div class="label">Department:</div>
                <div>
                    <select name="department">
                        <option value="Design">Design</option>
                        <option value="Business">Business</option>
                        <option value="Advertising">Advertising</option>
                        <option value="Research & development">Research & development</option>
                    </select>
                </div>
                <div class="button">
                <button>Send</button>
                </div>
            </form>
        </#if>

    </body>
</html>