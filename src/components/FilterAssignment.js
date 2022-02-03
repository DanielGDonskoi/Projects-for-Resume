import {useState} from 'react'
const FilterAssignment = ({onAdd}) => {
    const [coursecode,setAssignment] = useState('')
    const onSubmit = (e) => {
        e.preventDefault()
        if (!coursecode){
            alert("Please specify the class you want to filter")
        }
        onAdd({coursecode})
        setAssignment('')
    }
    return (
        <form className = "add-form" onSubmit={onSubmit}>
            <div className = "form-control">
                <label>Filter by class</label>
                <input type = "text" placeholder = "Input class code" value = {coursecode} onChange={(e) => setAssignment(e.target.value)}/>

            </div>
            <input type= "submit" name = "name" value = "Filter Assignments" className="btn btn-block"/>
        </form>
        
    )
}
export default FilterAssignment