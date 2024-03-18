const mongoose=require("mongoose");
mongoose.set("strictQuery",true);
mongoose.connect("mongodb://localhost:27017/SYCS")
.then(()=>console.log("Connnected to database"))
.catch((err)=>console.error("Connection error:",err));
const studentSchema=mongoose.Schema({
    name: String,
    age: Number,
    class: String,
    rollno: Number,
    email: String
},{collection:"students"});
module.exports={
    Student: mongoose.model("student",studentSchema),
};