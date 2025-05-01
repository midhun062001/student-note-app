export const InputBox = ({label, placeholder, forgetPassword, type}) => {
    return (
        <div className="p-3">
            <div className="flex items-center justify-between">
                <div className="font-bold">
                    {label}
                </div>
                <div className="text-sm text-gray-500 hover:text-gray-900 pointer cursor-pointer underline">
                    {forgetPassword}
                </div>
            </div>
            <input 
                type={type} 
                placeholder={placeholder} 
                className="w-full px-2 py-1 rounded border-gray-500 border"
                required 
            />
        </div>
    );
}