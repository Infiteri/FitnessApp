import Input from "../Input";

export default function InputMainPage({ placeholder, type = "text", ...fields }) {
    return (
        <Input 
            type={type} 
            placeholder={placeholder} 
            style="w-150 mb-6" 
            {...fields}   
        />
    );
}
