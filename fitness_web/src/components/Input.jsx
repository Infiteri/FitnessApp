export default function Input({ type = "text", placeholder = "", style = "", ...fields }) {
    return (
        <input
            type={type}
            placeholder={placeholder}
            className={
                style +
                " outline-1 text-2xl outline-neutral-600 bg-neutral-600 text-gray-200 px-6 py-3"
            }
            {...fields} 
        />
    );
}
