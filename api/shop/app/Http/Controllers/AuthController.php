<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use \App\Http\Controllers\BaseController as BaseController;
use Validator;
use App\Models\User;
use Illuminate\Support\Facades\Auth;

class AuthController extends BaseController {

    public function signUp( Request $request ) {

        $input = $request->all();

        $validator = Validator::make( $input, [

            "name" => "required",
            "email" => "required",
            "password" => "required",
            "confirm_password" => "required|same:password"
        ]);

        if( $validator->fails() ) {

            return $this->sendError( "Hibás adatok", $validator->errors() );
        }

        $input[ "password" ] = bcrypt( $input[ "password" ]);
        $user = User::create( $input );

        return $this->sendResponse( $user, "Felhasználó létrehozva" );
    }

    public function signIn( Request $request ) {

        if( Auth::attempt([ "email" => $request->email, "password" => $request->password ])) {

            $authUser = Auth::user();
            $success[ "token" ] = $authUser->createToken( "MyAuthApp" )->plainTextToken;
            $success[ "name" ] = $authUser->name;
            
            return $this->sendResponse( $success, "Hello" );
        
        }else {

            return $this->sendError( "Unauthorized.",[ "error" => "Sikertelen" ]);
        }

    }
    
    public function logout( Request $request ) {

        auth( "sanctum" )->user()->currentAccessToken()->delete();

        return response()->json( "Sikeres kijelentkezés" );
    }
}
