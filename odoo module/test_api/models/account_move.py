import requests
from odoo import models, fields, api
from odoo.exceptions import UserError

class LangEntity(models.Model):
    _name = 'my_module.lang_entity'
    _description = 'Language Entity'

    LanguageCode = fields.Char(string='LanguageCode', required=True)
    LanguageName = fields.Char(string='LanguageName', required=True)
    LanguageDesc = fields.Text(string='LanguageDesc')
    status = fields.Boolean(string='status', default=True)
    modifiedBy = fields.Char(string='modifiedBy')


@api.model
def create_language(self, LanguageCode, LanguageName,LanguageDesc, Status, modifiedBy ):
    url = 'http://localhost:8080/api/languages'
    payload = {
        'LanguageCode': LanguageCode,
        'LanguageName': LanguageName,
        'LanguageDesc': LanguageDesc,
        'status' :Status,
        'modifiedBy' :modifiedBy
    }
    try:
        response = requests.post(url, json=payload)
        response.raise_for_status()  # Raise an exception for 4xx or 5xx status codes

        # Language created successfully
        response_data = response.json()
        # Update the Odoo model with the response data or perform any necessary actions

    except requests.exceptions.RequestException as e:
        # Handle connection errors or API exceptions
        error_message = str(e)
        raise UserError(f"Failed to create language: {error_message}")


@api.model
def update_language(self, LanguageCode, LanguageName,LanguageDesc, Status, modifiedBy):
    url = f'http://localhost:8080/api/languages/{LanguageCode}'
    payload = {
        'LanguageCode': LanguageCode,
        'LanguageName': LanguageName,
        'LanguageDesc': LanguageDesc,
        'status' :Status,
        'modifiedBy' :modifiedBy
    }
    try:
        response = requests.put(url, json=payload)
        response.raise_for_status()  # Raise an exception for 4xx or 5xx status codes

        # Language updated successfully
        response_data = response.json()
        # Update the Odoo model with the response data or perform any necessary actions

    except requests.exceptions.RequestException as e:
        # Handle connection errors or API exceptions
        error_message = str(e)
        raise UserError(f"Failed to update language: {error_message}")


@api.model
def delete_language(self, LanguageCode):
    url = f'http://localhost:8080/api/languages/{LanguageCode}'
    try:
        response = requests.delete(url)
        response.raise_for_status()  # Raise an exception for 4xx or 5xx status codes

        # Language deleted successfully
        # Perform any necessary actions, such as updating the UI or displaying success messages

    except requests.exceptions.RequestException as e:
        # Handle connection errors or API exceptions
        error_message = str(e)
        raise UserError(f"Failed to delete language: {error_message}")