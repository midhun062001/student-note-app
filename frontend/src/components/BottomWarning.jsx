import { Link } from "react-router-dom"

export const BottomWarning = ({label, linkText, to}) => {
    return (
        <div className="text-sm flex justify-center py-2 text-gray-800">
            <div>
                {label}
            </div>
            <Link to={to} className="pointer underline cursor-pointer pl-1">
                {linkText}
            </Link>
        </div>
    );
}