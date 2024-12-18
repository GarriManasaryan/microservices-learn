from fastapi import FastAPI
from starlette.middleware.cors import CORSMiddleware
from port.adapters.backoffice.resource.router import project_route

# если надо функционально брать
# from port.adapters.backoffice.resource.requirements import requirements_router

# g_config = get_config()


def create_app(config=None) -> FastAPI:
    # if config is None:
    #     config = g_config

    app = FastAPI(root_path=".")

    # project_route.include_router(requirements.router)
    app.include_router(project_route)

    # middleware - intercepter
    app.add_middleware(
        CORSMiddleware,
        allow_origins=["*"],
        allow_credentials=True,
        allow_methods=["*"],
        allow_headers=["*"],
    )

    return app


# def custom_openapi():
#     if app.openapi_schema:
#         return app.openapi_schema
#     openapi_schema = get_openapi(
#         title="Custom title",
#         version="2.5.0",
#         summary="This is a very custom OpenAPI schema",
#         description="Here's a longer description of the custom **OpenAPI** schema",
#         routes=app.routes,
#     )
#     openapi_schema["info"]["x-logo"] = {
#         "url": "https://fastapi.tiangolo.com/img/logo-margin/logo-teal.png"
#     }
#     app.openapi_schema = openapi_schema
#     return app.openapi_schema

# http://0.0.0.0:5000/docs - local swagger
app = create_app()
# app.openapi = custom_openapi
