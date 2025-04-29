export const Button = ({label, onPress, type}) => {
    return (
        <button 
            onClick={onPress} 
            type={type} 
            className="w-full text-white bg-gray-800 rounded-lg hover:cursor-pointer text-sm py-2.5 mt-2"
        >
            {label}
        </button>
    );
}