<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
    </head>
    <body>
        <h1>Goldeneye</h1>
        <h2>Email Creator</h2>
        <#if employee?? >
            <p>This is your data:</p>
            <p>${employee.name}</p>
            <p>${employee.surname}</p>
            <p>${employee.location}</p>
            <p>${employee.department}</p>
            <p>and here is your company email:</p>
            <p>Email</p>
        <#else>
            <p>Please, fill the following form in order to receive a company email address.</p>
            <form action="/" method="post">
                <div>Name:</div>
                <input type="text" name="name">
                <div>Surname:</div>
                <input type="text" name="surname">
                <div>
                    <select name="location">
                        <option value="milan">Milan</option>
                        <option value="spain">Spain</option>
                        <option value="new_york">New York</option>
                    </select>
                </div>
                <div>
                    <select name="department">
                        <option value="design">Design</option>
                        <option value="business">Business</option>
                        <option value="advertising">Advertising</option>
                        <option value="research_development">Research & development</option>
                    </select>
                </div>
                <div>
                <button>Send</button>
                </div>
            </form>
        </#if>

    </body>
</html>