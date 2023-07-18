from odoo import http
import requests


class ReservationController(http.Controller):
    @http.route('/odoo_rest_module/reservation', type='json', auth='public', methods=['POST'])
    def create_reservation(self, **post):
        api_endpoint = 'http://localhost:8080/api/reservation'
        response = requests.post(api_endpoint, json=post)

        if response.status_code == 201:
            return {'success': True, 'message': 'Reservation created successfully'}
        else:
            return {'success': False, 'message': 'Failed to create reservation'}


    @http.route('/odoo_rest_module/reservation/<string:id>', type='json', auth='public', methods=['PUT'])
    def update_reservation(self, id, **post):
        api_endpoint = f'http://localhost:8080/api/reservation/{id}'
        response = requests.put(api_endpoint, json=post)

        if response.status_code == 200:
            return {'success': True, 'message': 'Reservation updated successfully'}
        else:
            return {'success': False, 'message': 'Failed to update reservation'}

    @http.route('/odoo_rest_module/reservation/<string:id>', type='json', auth='public', methods=['DELETE'])
    def delete_reservation(self, id):
        api_endpoint = f'http://localhost:8080/api/reservation/{id}'
        response = requests.delete(api_endpoint)

        if response.status_code == 204:
            return {'success': True, 'message': 'Reservation deleted successfully'}
        else:
            return {'success': False, 'message': 'Failed to delete reservation'}
