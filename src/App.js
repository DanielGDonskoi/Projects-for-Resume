import React from "react"
import {useState,useEffect} from "react"
import {BrowserRouter as Router,Route} from 'react-router-dom'
import './App.css';
import Header from "./components/Header"
import Button from "./components/Button"
import Assignments from "./components/Assignments"
import AddAssignment from "./components/AddAssignment"
import FilterAssignment from "./components/FilterAssignment"
import Navbar from "./components/Navbar"
import Footer from "./components/Footer"
function App() {
  const onApp = (e) => {
    console.log("Filtered")
}
  
  const [assignments,setassignments] = useState([
    
])
useEffect(() => {
  const getAssignments = async () => {
    const assignmentspassed = await fetchData()
    setassignments(assignmentspassed)

  }
  getAssignments()
},[])

const fetchData = async() => {
  const res = await fetch(`http://localhost:5000/assignments`)
  const data = await res.json()
  
  return data
}

const deleteassignment = async(assignment3) => {
    const found = (assignments.find(element => element.name == assignment3.name && element.coursecode == assignment3.coursecode)).id
    await fetch(`http://localhost:5000/assignments/${found}`,{
      method:'DELETE'
    }
    )
    
    
    setassignments(
      assignments.filter(assignment => (assignment.name !== assignment3.name || assignment.coursecode !== assignment3.coursecode) 
      ))
    
  
}
const addassignment = async(assignment) => {
  const res = await fetch (`http://localhost:5000/assignments`,{
    method: 'POST',
    headers: {
      'Content-type':'application/json'
    },
    body: JSON.stringify(assignment)
  })
  const data = await res.json()
  setassignments([...assignments,data])
  //const id = Math.floor(Math.random() * 10000) + 1
  //const newAssignment = {id,...assignment}
  //setassignments([...assignments,newAssignment])
  //console.log(assignment)
}
const FilterAssignments = (assignment2) =>{
  console.log(assignment2.coursecode)

  setassignments(assignments.filter(assignment => assignment.coursecode == assignment2.coursecode))
  
  console.log("Filtered2")
}
  return (
    <div>
    <Navbar/>
    
    <Router>
    <div className="container">
    <Header/>
    
    <AddAssignment onDelete = {deleteassignment} onAdd={addassignment}/>
    
    <div>
    <Assignments assignments={assignments} />
    </div>
    <FilterAssignment onAdd={FilterAssignments}/>
    </div>
    </Router>
    <Footer/>
    </div>
  );
}

export default App;
