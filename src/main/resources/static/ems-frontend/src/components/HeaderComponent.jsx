import React from 'react'
import { useNavigate } from 'react-router-dom'



const HeaderComponent = () => {

  const navigator = useNavigate();

  function addNewEmployee(){
    navigator('/add-employee')
  }
  function ListEmployees(){
    navigator('/employees')
  }


  return (
    <div>
        <header>
          <nav class="navbar navbar-dark navbar-expand-lg  bg-primary">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">ETERNO CRM</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="" onClick={addNewEmployee}>Add Employee</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="" onClick={ListEmployees} >List Employee</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
        </header>
    </div>
  )
}

export default HeaderComponent