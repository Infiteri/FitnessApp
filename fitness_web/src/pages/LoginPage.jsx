import { useState } from "react";
import Button from "../components/Button";
import Header from "../components/Header";
import Hyperlink from "../components/Hyperlink";
import InputMainPage from "../components/specifics/InputMainPage";
import Utils from "../utils/Utils";
import ApiUtils from "../utils/ApiUtils";
import { Navigate, useNavigate } from "react-router-dom";

export default function LoginPage() {
    const [password, setPassword] = useState('');
      const navigate = useNavigate();

    const [phoneNumber, setPhoneNumber] = useState('');

    const invalidCredentials = (message) => {
        console.error(message);
    }

    const handleLoginButton = async () => {
        if (password.length === 0 || phoneNumber.length === 0) {
            invalidCredentials("EMPTY FIELDS");
            return
        }

        if (!Utils.ValidatePhoneNumber(phoneNumber)) {
            invalidCredentials("BAD PHONE");
            return;
        }

        const res = await ApiUtils.Fetch("/api/v1/user/login?phoneNumber=" + Utils.FormatPhoneNumber(phoneNumber) + "&password=" + password, {
            method: "POST"
        });

        if (res.ok) {
            localStorage.setItem("phoneNumber", phoneNumber);
            navigate("/user");
        }
        else {
            invalidCredentials("Coulnd't login")
            setPassword("");
            setPhoneNumber("")
        }
    }

    return (
        <div className="w-screen h-screen pb-25 flex flex-col gap-8 items-center justify-center">
            <Header text="Login" style="text-7xl mb-10" />

            <InputMainPage placeholder="Phone Number..." value={phoneNumber} onChange={(e) => { setPhoneNumber(e.target.value) }} />
            <InputMainPage placeholder="Password..." type="password" value={password} onChange={(e) => { setPassword(e.target.value) }} />

            <Button text="Login" style="text-3xl bg-blue-500 px-20 py-3 font-bold text-white rounded-lg" onClick={handleLoginButton} />

            <Hyperlink text={"Don't have an account? Sign up :)"} href={"/signup"} />
        </div>
    )
}
