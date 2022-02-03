import {useState} from "react"
const AddAssignment = ({onAdd,onDelete}) => {
    const [name,setName] = useState('')
    const [coursecode,setAssignment] = useState('')
    const ondelete1 = () =>  {
        console.log("test")
        onDelete({name,coursecode})
    }
    const onSubmit = (e) => {
        e.preventDefault()
        if (!name) {
            alert("Please add a name for the assignment")
        }
        else if (!coursecode) {
            alert("Please specify the class for the assignment")
        }
        
        onAdd({name,coursecode})
        setName('')
        setAssignment('')
        
    }
    return (
        <div>
        <form className = "add-form" id="form1" onSubmit={onSubmit} onDelete={onDelete}>
            <div className = "form-control">
                <label>Name</label>
                <input type = "text" placeholder = "Input Assignment Name" value = {name} onChange={(e) => setName(e.target.value)}/>

            </div>
            <div className = "form-control ">
                <label>Class</label>
                <input type = "text" placeholder = "Input Class Coursecode" value = {coursecode} onChange={(e) => setAssignment(e.target.value)}/>
                
            </div>
            <button type="button" name="name" onClick={ondelete1} value = "Remove Assignment" className="btn btn-block">Remove Assignment</button>
            <input type= "submit" name = "name" value = "Add Assignment" className="btn btn-block"/>
            
            
        </form>
        </div>

        
        
        
        
    )
    }
    

export default AddAssignment